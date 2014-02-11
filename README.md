TipsNTricks
===========

###Ctrl-C ile projeyi reload yapmak

**nedir:** Bir programı ctrl-c ile restart etmek için.
   
**neden:** Normalde Intellij projeyi reload ediyordu; Şuanda kullandığım bilgisayarda herhangi bir IDE olmadığı için proje değiştiğinde her seferinde ctrl-c , ./gradlew runmod -i yazmak yerine böyle bir trick kullandım.

```bash
#!/bin/bash
while :
do
   ./gradlew runMod -i  # çalıştırmak istediğimiz komut
   sleep 1
done
```

### Terminali temizle
**nedir:** Terminale clear screen karakteri göndermek için.

**neden:** Deploy redeploy yaparken bağzen terminali temizlemek gerekiyor her seferinde command-k yapmak yerine App çalışınca ilk önce clear karakteri yollaya bilirsiniz.

```javascript
process.stdout.write("\033[2J\033[1;1H");
```


###Screen chuck noris attach mode

**nedir:** Attach here and now. Whatever that means, just do it.
   
**neden:** ezbere bildiğim tek screen komutu. her gün kullanıyorum.

```bash
screen -D -RR
```



###Apache benchmark ile stress test

**nedir:** ab ile bağzen hızlıca web projesini test etmek gerekiyor. 
`-n` toplam kaç tane request yollanacak.
`-c` aynı anda kaç tane istek yollanacak.
`-k` keepalive
   
**neden:** Stress test edilmeyen proje productionda strese girer bu yüzden.

```bash
ab -n10000 -c10 -k "http://localhost:8080/blahblah"
```


###Ping broadcast

**nedir:** Local network deki bütün makinalara aynı anda ping atmak için. `192.168.1.255` broadcast adresi.

**neden:** Geçen gün time capsule ün ipsini unuttum, networkde ki online makinaların listesini çıkartıp teker teker denedim. bknz: nmap

```bash
ping -b 192.168.1.255
```


Faydalı Araçlar
===========

* [Homebrew] - OSX için paket yöneticisi. 
* nmap - `brew install nmap` - network scanner (matrix de trinity nüklear santrali hacklerken kullanıyordu 8) )
* ab - `brew install ab` - web sitesi load generator
* htop - `brew install htop` - renkli top
* groovy - `brew install groovy` - Syntax'ı güzel java, shell script yazarkende işe yarıyor
* [Synergy] - Tek klavye mouse'u bir den fazla makinaya paylaştırmak için windows osx linux driverları var
* [Vertx.io] - JVM üzerinde çalışan hızlı, polygot (birden fazla programlama dili desteği olan), node.js den esinlenmiş, application patformu 
* [SourceTree] - Atlassian'ın git client'ı. windows versiyonu biraz çirkin.

[Homebrew]: http://brew.sh/
[Synergy]: http://synergy-foss.org/
[Vertx.io]: http://vertx.io/
[SourceTree]: http://www.sourcetreeapp.com/
