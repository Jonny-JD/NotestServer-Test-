kube-config:
  mkdir -p ~/.kube
  echo "${{ secrets.KUBECONFIG }}" > ~/.kube/config

create-test-namespace:
  kubectl create namespace test || echo "Namespace already exists"

create-secrets:
  kubectl create secret generic db-credentials \
      --from-literal=POSTGRES_USER=${{ secrets.TEST_DB_USER }} \
      --from-literal=PASSWORD=${{ secrets.TEST_DB_PASS }} \
      --from-literal=POSTGRES_DB=${{ secrets.TEST_DB_NAME }} \
      -n ci \
      --dry-run=client -o yaml | kubectl apply -f -

deploy-test-backend:
  kubectl apply -f infra/k8s/test/backend-test-deployment.yaml

deploy-test-frontend:
  kubectl apply -f infra/k8s/test/frontend-test-deployment.yaml

cleanup-namespace:
  kubectl delete namespace ci || echo "Namespace already deleted"
