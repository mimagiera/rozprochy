protoc.exe -I=proto_source --java_out=generated_java --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java.exe --grpc-java_out=generated_java proto_source/events.proto
