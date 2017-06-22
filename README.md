# Csvhandler
Консольное приложение, осуществляющее поиск столбцов по шаблону.

### Параметры:
```-i``` -путь к входному файлу (*.csv).

```-q``` -шаблон для поиска(Может быть регулярным выражением).

```-o``` -путь к файлу с результатами работы (*.csv или *.txt)

#### Пример входного CSV:

```csv
The Internet was invented in the late by the Defense Department 
there was a network.com of just four mainframe Internet A mainframe
computer is a large powerful computer.com shared by many users The idea 
when users looked.com for a way to talk to each other electronically By
the Internet had begun to develop into the form we know today Electronic 
mail because once the message.com is typed out Internet arrives in the electronic
mail box of the recipient within minutes It’s better to use e-mail to contact 
because Internet is cheaper for long distances than the phone People can
share their interests through the Internet and it makes it very easy to 
```
#### Пример выходного CSV с шаблоном поиска "Internet":

```java
Internet was is users Internet because box Internet their 
the just computer.com way develop is within long Internet 
the Internet many to form Internet better the makes
```

#### Пример выходного TXT с шаблоном поиска "Internet":

```java
Internet
was
is
users
Internet
because
box
Internet
their
the
just
computer.com
way
develop
is
within
long
Internet
the
Internet
many
to
form
Internet
better
the
makes
```

```
 Приложение находиться в папке target/csvhandler.jar
```