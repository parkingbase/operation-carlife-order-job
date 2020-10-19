mvn clean package fabric8:build fabric8:push -Paliyun -DskipTests
kubectl delete cronjob opeartion-carlife-oil-job
kubectl create -f ./target/classes/META-INF/fabric8/kubernetes/operation-carlife-order-job-cronjob.yml