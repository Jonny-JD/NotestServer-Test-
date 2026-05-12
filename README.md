# Notes — Autotests

UI autotests for the **Notes** full-stack pet project, covering both desktop and mobile viewports.

## Tech Stack

- **Java 21**
- **Selenide 7.16.0** + **Selenium 4.43.0**
- **JUnit Jupiter 5.10.0**
- **Allure** (allure-selenide + allure-junit5)
- **Gradle** (build tool)
- **Kubernetes** + **Selenium Grid** (Hub + Chrome + Firefox)

## Project Structure

```
src/test/java/com/jimmy_d/autotests/
│
├── common/                        # Cross-viewport functional tests
│   ├── NoteCreateTest             # Guest and authenticated note creation
│   └── UserRegisterAndLoginTest   # Registration and login flow
│
├── desktop/                       # Desktop viewport tests (1366x768)
│   ├── GreetingPageDesktopTest
│   ├── LoginPageDesktopTest
│   ├── RegisterPageDesktopTest
│   ├── MainPageDesktopTest
│   ├── CreatePageDesktopTest
│   └── DiscoverPageDesktopTest
│
├── mobile/                        # Mobile viewport tests (390x844)
│   ├── GreetingPageMobileTest
│   ├── LoginPageMobileTest
│   ├── RegisterPageMobileTest
│   ├── MainPageMobileTest
│   ├── CreatePageMobileTest
│   └── DiscoverPageMobileTest
│
├── page/                          # Page Object Model
│   ├── object/                    # Reusable UI components
│   │   ├── Form
│   │   ├── MenuButtonsAside       # Desktop sidebar navigation
│   │   ├── MenuButtonsToggle      # Mobile hamburger navigation
│   │   ├── Note
│   │   ├── OptionsBlockForm
│   │   └── TextArea
│   ├── BasePage
│   ├── GreetingPage / MainPage / LoginPage / RegisterPage
│   ├── CreatePage / DiscoverPage
│   ├── MyNotesPage / ProfilePage
│
├── BaseTest.java                  # Selenide + RemoteWebDriver config
├── TestFactory.java               # Test data generators and reusable actions
└── User.java                      # User record
```

## Test Coverage

### Functional (common)
| Test | Description |
|------|-------------|
| `createGuestNoteTest` | Creates a note as a guest, verifies it appears in Discover feed |
| `createUserNoteTest` | Registers + logs in a user, creates a note, verifies it in My Notes |
| `assertTestRegisterAndLogUser` | Full register → login → profile verification flow |

### UI / Desktop & Mobile
Each page is tested for:
- Navigation menu state (correct buttons for unauthenticated user)
- Form structure (expected fields and submit button)
- Button visibility and click behaviour
- Correct URL routing after actions

Mobile tests mirror desktop tests with a `390x844` viewport and toggle-based navigation instead of sidebar.

## CI/CD

Tests are triggered manually via `workflow_dispatch` on a **self-hosted runner** inside the cluster.

The pipeline performs a full lifecycle on every run:

```
workflow_dispatch
       │
       ▼
Clone backend + frontend (feature branch)
       │
       ▼
Build {sha}-test images → push to Docker Hub
       │
       ▼
Deploy full test environment to namespace "test"
  ├── backend
  ├── frontend
  └── Selenium Grid (Hub + Chrome + Firefox)
       │
       ▼
kubectl rollout status (wait for readiness)
       │
       ▼
Port-forward Selenium Hub → localhost:4444
       │
       ▼
./gradlew test
       │
       ▼
Generate Allure report → upload as GitHub artifact
       │
       ▼
Cleanup: delete namespace + reset test database
```

## Test Environment

| Variable       | Default                          | Description                  |
|----------------|----------------------------------|------------------------------|
| `SELENIUM_HUB` | `http://localhost:4444`          | Selenium Grid Hub URL        |
| `APP_URL`      | `http://host.docker.internal:5173` | Application URL under test |

Tests connect to the app and Selenium Hub via Kubernetes internal service DNS names when running inside the cluster.

## Related Repositories

- [NotesServer Backend](https://github.com/Jonny-JD/NotesServer-B-) — Java 21, Spring Boot, PostgreSQL
- [NotesServer Frontend](https://github.com/Jonny-JD/NotesServer-F-) — React, TypeScript, Vite
- [NotesServer Infrastructure](https://github.com/Jonny-JD/NotesServer-Infrastructure) — Kubernetes (K3s), Helm, Traefik, Let's Encrypt, GitHub Actions

## About

This project was built for my portfolio. It demonstrates:
- UI test automation with Selenide and JUnit 5
- Page Object Model with reusable component objects
- Cross-viewport testing (desktop + mobile)
- Running tests inside a Kubernetes cluster against a fully deployed application
- End-to-end CI/CD: build app images → deploy environment → run tests → publish Allure report → cleanup
