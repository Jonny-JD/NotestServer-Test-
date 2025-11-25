.PHONY: kube-config create-test-namespace create-secrets deploy-test-backend deploy-test-frontend cleanup-namespace

kube-config:
	mkdir -p ~/.kube
	echo "${KUBECONFIG}" > ~/.kube/config

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
	kubectl apply -f infra/k8s/test/backend-test-deployment.yaml

deploy-test-frontend:
	kubectl apply -f infra/k8s/test/frontend-test-deployment.yaml

cleanup-namespace:
	kubectl delete namespace test || echo "Namespace already deleted"
