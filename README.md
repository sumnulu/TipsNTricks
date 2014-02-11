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
