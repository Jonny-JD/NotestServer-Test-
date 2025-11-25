.PHONY: create-test-namespace create-secrets deploy-test-backend deploy-test-frontend cleanup-namespace

create-test-namespace:
	kubectl create namespace test || echo "Namespace already exists"

create-secrets:
	kubectl create secret generic db-credentials \
		--from-literal=username=${TEST_DB_USER} \
		--from-literal=password=${TEST_DB_PASS} \
		-n test \
		--dry-run=client -o yaml | kubectl apply -f -

deploy-test-backend:
	envsubst < infra/k8s/backend-deployment.yaml | kubectl apply -f -

deploy-test-frontend:
	envsubst < infra/k8s/frontend-deployment.yaml | kubectl apply -f -

cleanup-namespace:
	kubectl delete namespace test || echo "Namespace already deleted"
