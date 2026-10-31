## CACERT

1. **What is a CACERT file?**  
   It's a **Certificate Authority (CA) Certificate** file that contains the trusted certificates for SSL/TLS communication. It tells your system which certificates are trustworthy when establishing secure connections, like HTTPS or secured APIs.

2. **Why is it related to your project?**  
   Even though you're just coding, your application might:
   - Communicate with external services (e.g., REST APIs, databases, or third-party tools).
   - Clone dependencies from secure repositories (like Maven Central or private registries).
   - Need to validate certificates when interacting with these services.  
   
   If the CA certificate used by these services isn’t recognized by your system (or is missing), you’ll see issues like "certificate validation failed."

3. **How does this happen during cloning or building?**  
   - When you clone a repository over HTTPS, Git or your IDE verifies the server's certificate using the system's CA certificate store.
   - If the CA certificate isn’t present in your system's trusted store, you'll get an error.
   - Similarly, during builds, tools like Maven or Gradle might fail to fetch dependencies if there's an SSL issue.

4. **How to resolve it?**  
   - Add the CA certificate of the service you're interacting with to your system's trust store or your application’s keystore.
   - For Git issues, you can explicitly point to the `cacert.pem` file via configuration:
     ```bash
     git config --global http.sslCAinfo /path/to/cacert.pem
     ```
   - For Java-based projects, update the `cacerts` file in your JDK using the `keytool` command:
     ```bash
     keytool -import -trustcacerts -file <your_cert>.crt -keystore $JAVA_HOME/lib/security/cacerts -alias <your_alias>
     ```
     (You might need admin rights for this.)

In short, the CACERT issue comes into play because modern software uses secure communication protocols, and ensuring trust via CA certificates is a core part of it. It’s all about security.




## When to use Cacerts in project.

1. **If the server uses its own/self-signed certificates:**  
   - You need to manually download and add the certificate (using the `keytool` command) to your JDK or system trust store to make it work.  

2. **If the server uses well-known certificates (like DigiCert, Let's Encrypt, etc.):**  
   - You don’t need to do anything. These certificates are already trusted by your system and JDK, so you can directly call their APIs.

That’s the core idea! Now, to check if a server is using a self-signed certificate or a trusted one, you can do this:  

- Open the API URL in a browser (e.g., `https://jira-api.example.com`) and check the **certificate details** in the lock icon next to the URL.
- If it shows the certificate is issued by a known CA like DigiCert, you’re good. If it says "self-signed" or "unknown CA," then you'll need to add the CACERT manually.



