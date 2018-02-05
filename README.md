# The-Signature
Software Process Management Project

###Thai Language
##โปรเจคดังกล่าวมีการใช้ tomcat และ maven และขอข้ามการติดตั้งทั้ง 2

หลังจาก clone โปรเจคแล้ว ให้ไปที่ไฟล์ ${Catalina_Home}/bin/catalina และใส่ค่า root project of The-Signature

```bash
set     PATH_PROJECT_SIGNATURE=.......             /// For Window
export  PATH_PROJECT_SIGNATURE=.......             /// For Linux
```

จากนั้นทำการสร้างไฟล์ .env จาก .env.example ที่ root project of The-Signature ด้วยคำสั่ง

```bash
cp .env.example .env
```

จากนั้นทำการเซตค่าเพื่อเชื่อม database ในไฟล์ .env 

ต่อไปทำการโหลด dependencies ไว้ในโปรเจ็คของเราด้วยคำสั่ง 

```bash
mvn install
```

หากตัองการเทส ให้ใช้คำสั่ง

```bash
mvn test
```

#How to deploy on tomcat server by Maven

การ deploy สามารถเซ็ตค่าสำหรับการ deploy ได้ที่ pom.xml ซึ่งสามารถเซ้ตค่า URL ที่ต้องการอัพหรือ Context Path

หากต้องการ deploy ขึ้น server tomcat ให้ใช้คำสั่ง

```bash
mvn tomcat7:deploy
```

หากต้องการอัพเดทโปรเจค ขึ้น server tomcat ให้ใช้คำสั่ง

```bash
mvn tomcat7:redeploy
```

หากต้องการยกเลิกโปรเจคที่ deploy ให้ใช้คำสั่ง

```bash
mvn tomcat7:undeploy
```

###English Language
##This project use tomcat and maven  

after you already clone the project. Please find the file "${Catalina_Home}/bin/catalina" and input "root project of The-Signature"

```bash
set     PATH_PROJECT_SIGNATURE=.......             /// For Window
export  PATH_PROJECT_SIGNATURE=.......             /// For Linux
```

then create file .env from .env.example in folder root project of The-Signature with this command

```bash
cp .env.example .env
```

then set value to connect database in file .env

and download dependencies and save into your project with this command

```bash
mvn install
```

if you want to test. use this command

```bash
mvn test
```

#How to deploy on tomcat server by Maven

for deploy, you can set value for deploy in file pom.xml which you can set url to deploy

if you want to deploy on tomcat server. use this command.

```bash
mvn tomcat7:deploy
```

if you want to update project on tomcat server. use this command.

```bash
mvn tomcat7:redeploy
```

if you want to delete project after you deployed. use this command.

```bash
mvn tomcat7:undeploy
```

#Member
58130500004 Kittitat Rattanapinyopas
58130500008 Khemanij Mantanajaru
58130500013 Jackrit Yangsung
58130500024 Chanon Thongsuk
58130500038 Teeradet Phondetparinya
58130500049 Patiphan Thonguam