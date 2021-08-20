# Console Project

- Создать пользователя со следующими параметрами: имя, фамилия, email, роли, мобильные телефоны и сохранить его в файл.
- Кол-во телефонов от 1 до 3-х
- Выбрать пользователю роли: USER (ур1), CUSTOMER(ур1), ADMIN (ур2), PROVIDER(ур2), SUPER_ADMIN (ур3)
- Одновременно пользователь может иметь по 1 роли с каждого уровня, например: USER+ADMIN, CUSTOMER+PROVIDER, USER+PROVIDER, но не USER+CUSTOMER, ADMIN+PROVIDER
- Если у пользователя указана роль SUPER_ADMIN - другие роли выбирать запрещено
- При попытке ввести некорректное кол-во или сочетание записей выводить сообщение о том, что кол-во неверно и дать повторить попытку ввода.
- Валидировать email и телефоны:
- телефоны должны быть в виде 375 *****, к примеру, | 37500 1234567 |.
- email в виде *****@*****.*, к примеру, | any@email.com |. Т.е. достаточно проверки на ‘@’ и точку
- Редактировать уже существующего пользователя.
- учесть все валидации и ошибки из предыдущего пункта
- Удалить пользователя.
- Получать информацию о пользователе, его ролях и телефонах (вывод на консоль).
- Получить и вывести всех пользователей
- Консольный ввод

