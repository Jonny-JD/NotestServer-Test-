.PHONY: create-test-namespace create-secrets deploy-test-backend deploy-test-frontend cleanup-namespace

create-test-namespace:
	kubectl create namespace test || echo "Namespace already exists"

create-secrets:
	kubectl create secret generic db-credentials \
		--from-literal=POSTGRES_USER=${TEST_DB_USER} \
		--from-literal=PASSWORD=${TEST_DB_PASS} \
		--from-literal=POSTGRES_DB=${TEST_DB_NAME} \
		-n test \
		--dry-run=client -o yaml | kubectl apply -f -

deploy-test-backend:
	envsubst < infra/k8s/backend-deployment.yaml | kubectl apply -f -

deploy-test-frontend:
	envsubst < infra/k8s/frontend-deployment.yaml | kubectl apply -f -

cleanup-namespace:
	kubectl delete namespace test || echo "Namespace already deleted"
