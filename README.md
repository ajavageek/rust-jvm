# How to call rust from java


## Building rust

Ensure you have maven and rust installed. 

For example on macos with apple silicon: 

```bash
cd lib-rust
rustup target add x86_64-apple-darwin
cargo build --target x86_64-apple-darwin
cp target/x86_64-apple-darwin/debug/libdummymath.dylib ../use-java/
```

You can adjust this for you platform, but what this does is install the x86_64 builder and build a rust binary for x86_64. The binary will be loaded by the `use-java` code. 

## Building and running from java

```bash
cd ../use-java
mvn package
```

You can then run the Main class from your IDE or from the command line. 

This will load the libdummymath.dylib and call the rust code. 




