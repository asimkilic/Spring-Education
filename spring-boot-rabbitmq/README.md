## Rabbit MQ

<img src="https://github.com/asimkilic/Spring-Education/blob/master/spring-boot-rabbitmq/img/RabbitMQ.png" alt="RabbitMQ" style="max-width: 100%;">

Kuyruk tanımını kısaca  mesajlarımız bir yerlere yazılıyor ve o yazdığımız mesajlar sırayla tüketilmesini sağlıyor ve o sıralama konusunda değişiklik yapabiliyoruz. RabbitMQ 'nun desteklediği birden fazla iletişim türü var.

Bir kuyruk sunucusuna client olmak vardır, burada kuyruk sunucumuz RabbitMQ, buna iki türlü client olabiliyoruz. Birinci türümüz *Producer* olarak client olmak yani kuyruğa veriyi yazan kişi olmak. İkincisi ise kuyruktan veriyi okuyan kişi yani *Consumer* olmak. Consumer kuyruktaki veriyi tüketiyor, veriyi okuyor Producer ise yazıyor. 

İletişim tiplerinde ise;

- Direct : Kuyruğa yazılan her veri mutlaka bir kişi tarafından tüketilir. Bu kuyruğa Consumer olmuş bir veya birden fazla kişi olabilir. Kuyruktan veri okuyan beş tane Client'ımız olsun, Direct iletişim tipini seçtiğimiz zaman beş Consumer'ımızdan bir tanesi  mutlaka mesajı alıp, işler ama burada bir Client diğer bir Client'tan haberdar olmayabilir. Yani ne kadar  Client olduğunu veya hangi Client'ın tükettiğini Client tarafında bilmiyor oluyoruz. 
- Fanout: Direct çalışmasına benzer ama mesajı her Client'a gönderen bir yapısı var.  Bütün iletişim tiplerinde Producer sayısında bir limit yoktur. Fanout'ta ise bir mesaj kuyruğa yazıldıktan sonra o mesajı birden fazla Consumer'a teslim etmesi için tasarlanmıştır. Buradaki mantığı  beş tane Consumer'ımız var ise kuyruğa bir mesaj geldiğinde o beş Clien'ın beşinede gitmesini sağlıyor. Bu durumda da aslında şu oluyor; biraz daha pub-sub dediğimiz mimarı yapısı vardır diyebiliriz.
- Topic:  Burada ise biraz daha Direct ve Fanout'un birleşimi şeklinde diyebiliriz. Kuyruk üzerinde belirli konfigürasyonlar yapabiliyoruz. Örneğin 'eu.de' uzantısında bir mesaj geldiğinde (pattern'lar da yazabiliyoruz), bu mesajlar Queue 2' ye gitsin Direct gibi davransın bi takım mesajlarda Queue 3'e gitsin Fanout gibi davransın, tümünü teslim etsin. Biraz daha diğer iki iletişim tipinin birleşmiş halidir.



Projemize bir maven module ekliyoruz. Resources altına bir tane **docker-compose.yml**  dosyası oluşturuyoruz( [RabbitMQ Docker Image ](https://hub.docker.com/_/rabbitmq/) ).

```dockerfile
version: '3.1'
services:
  spboot-rabbitmq:
    image: rabbitmq:3-management
    ports:
      - '5672:5672'
      - '15672:15672'
    environment:
      - RABBITMQ_DEFAULT_USER=asimkilic
      - RABBITMQ_DEFAULT_PASS=asimkilic
```

```powershell
PS C:\springExamples\spring-boot-rabbitmq\src\main\resources> docker-compose -f docker-compose.yml up -d
```

daha sonra ara yüze bağlanabiliriz.

http://localhost:15672/

Eğer kullanıcı adı ve  şifreyi docker-compose içerisinde vermezsek default  guest - guest olarak atıyor.

Pom.xml için dependency'lerimiz;

```xml

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

Resources altına **application.properties** ayar dosyamızı oluşturup ilk ayarlarlarımızı ekliyoruz.

```xml
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=asimkilic
spring.rabbitmq.password=asimkilic

sr.rabbit.queue.name = asim-kilic-queue
sr.rabbit.exchange.name = asim-kilic-exchange
sr.rabbit.routing.name = asim-kilic-routing

```

