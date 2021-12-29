## Kurulumlar

- [JDK 11 LTS](https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html)

- [Docker Desktop](https://www.docker.com/products/docker-desktop)

- [Robo Mongo](https://robomongo.org/download)

  

## Start a `mongo` server instance

```console
$ docker run --name some-mongo -d mongo:latest
```

Default portu bizim local portumuza export etmediğimiz için pek bir anlam ifade etmeyecek kurulum. Bir tane docker image'ımız çalışıyor ama dışarıya portu açık olmadığı için ona erişemeyizde kullanamayızda 

```json
docker ps
docker run --name some-mongo -p 27017:27017 -d mongo:latest
```

komutu ile çalışan imajlarımızı görebiliriz.

```json
docker run --name some-mongo -p 27017:27017 -d mongo:latest
```

diyerek direk portu yönlendirme yapabiliriz.

Bunun yerine biz docker compose dosyası oluşturacağız.

src > main > resources altına **docker-compose.yml** dosyamızı oluşturuyoruz

```dockerfile
version: '3.1'
services:
  mongo:
    image: mongo
    command: --serviceExecutor adaptive
```

artık sadece bizim bu dosyayı çalıştır dememiz lazım.
