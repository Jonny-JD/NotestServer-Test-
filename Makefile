kube-config:
  mkdir -p ~/.kube
  echo "${{ secrets.KUBECONFIG }}" > ~/.kube/config

create-test-namespace:
  kubectl create namespace test || echo "Namespace already exists"

deploy-test-backend:
  kubectl apply -f infra/k8s/test/backend-test-deployment.yaml

deploy-test-frontend:
  kubectl apply -f infra/k8s/test/frontend-test-deployment.yaml

cleanup-namespace:
  kubectl delete namespace ci || echo "Namespace already deleted"
