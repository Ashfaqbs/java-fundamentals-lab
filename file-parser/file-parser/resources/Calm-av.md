
``````

Pull the calmav image 

C:\Users\ashfa>docker pull clamav/clamav
Using default tag: latest
latest: Pulling from clamav/clamav
1f3e46996e29: Pull complete
9fbdb00a81ac: Pull complete
8a3c7bd38def: Pull complete
f5169dcf6097: Pull complete
77da41c4ccae: Pull complete
1de8cfd61eea: Pull complete
f9970735b6ec: Pull complete
Digest: sha256:268a6ad4bc1dbe6645204f3ab421827587a1ec131f21d92b5ce5dba751f43bdd
Status: Downloaded newer image for clamav/clamav:latest
docker.io/clamav/clamav:latest

What's next:
View a summary of image vulnerabilities and recommendations → docker scout quickview clamav/clamav


- Run the image

C:\Users\ashfa>docker run --name clamav -d -p 3310:3310 clamav/clamav
dcf6eeab2381a9f75d3e367911cf5a8a8af93acf6a113e1da69530a2c1b6d867

C:\Users\ashfa>curl localhost:3310
curl: (1) Received HTTP/0.9 when not allowed


C:\Users\ashfa>



``````




Optional providing the config path (didnot run the container)
```
C:\Users\ashfa>docker run --name clamav -d -p 3310:3310 -v /path/to/local/clamav/config:/etc/clamav clamav/clamav
3196ce8f3b2ed3ef2b3593cea4bc7051a8147f287bcfbbb0e3446a3a096ccb55`
````````