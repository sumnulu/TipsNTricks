Poor Man's Aws Persistent Spot Instance
==================================

AMI image'de ki ROOT volume'dan phase_1 çağırılacak.
Persistent olması gereken ROOT volume'dan phase_2 çağırılacak.

**ÖNEMLİ UYARI**    Script fena kötü, ama bir yildir işimi görüyor onun için dokunmuyorum.
Bazen arka arkaya resetleniyor, sonra kendine geliyor. 

Todo
-------
* Ne işe yaradığını doğru düzgün anlat
* Scripti baştan yaz.

Not
--------
Eger amazon soft reset'i kaldırırsa benzer bir şey `PIVOT_ROOT(8)` ile yapılabilir.
