# Домашнее задание к занятию "Исключительные ситуации и их обработка. Тестирование исключений"

## Задание 1. NotFoundException

Вы развиваете приложение с менеджером товаров, и решили сделать так, чтобы при попытке удаления несуществующего объекта из репозитория генерировалось ваше исключение, а не `ArrayIndexOfBoundsException`.

Обратите внимание: это правильный подход, поскольку таким образом вы сообщаете (через генерацию исключения), что это исключение, вписывающееся в вашу логику, а не является ошибкой программиста.

**Что нужно сделать:**
1. Возьмите проект [в рамках дз про наследование](https://github.com/Ekaterina-Isabel/Product_Manager) с менеджером, репозиторием и товарами.
1. Создайте класс исключения `NotFoundException` отнаследовавшись от `RuntimeException` и реализуйте как минимум конструктор с параметром-сообщением (он будет просто вызывать супер-конструктор предка)
1. В методе удаления `removeById` сначала проверяйте, есть ли элемент (для этого прямо из метода `removeById` вызывайте метод `findById`: если результат - `null`, тогда выкидывайте исключение `NotFoundException`)
1. Напишите 2 автотеста на репозиторий: первый должен проверять успешность удаления существующего элемента, второй - генерации `NotFoundException` при попытке удаления несуществующего элемента

Для реализации этой логики вам понадобится добавить метод `findById`, предназначенный для поиска товара в репозитории по его id. Так, он должен принимать параметром `id` искомого товара, пробегаться по всем товарам репозитория и сверять их `id` с искомым, в случае совпадения делать `return` этого товара. Если же пробежав все товары репозитория ни один подходящий найден не был (т.е. цикл закончился без вызова `return` внутри него), то следует сделать `return null`.

Убедитесь, что ваши автотесты проходят (проект должен быть на базе Maven, с подключенными зависимостями и необходимыми плагинами).

**Итого:** у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код и автотесты к нему.

Мы рекомендуем вам указывать в сообщении исключения: при удалении по какому конкретно id было сгенерировано ваше исключение.
Сделать это можно следующим образом (простейший способ): ```"Element with id: " + id + " not found"```.

**Итого:** отправьте на проверку ссылку на гитхаб-репозиторий с вашим проектом.


## Задание 2*. AlreadyExistsException

В том же самом проекте и в той же самой ветке добавьте следующую новую функциональность. В методе добавления нового товара в репозиторий должна осуществляться проверка на то, что в нём нет уже товара, у которого бы совпадал `id` с `id` добавляемого товара. Если же такой уже есть, то должно выкидываться ваше исключение - 
`AlreadyExistsException`. 

Напишите 2 автотеста на репозиторий: первый должен проверять успешность добавления элемента, второй - генерации `AlreadyExistsException` при попытке добавить элемент с повторяющимся `id`.

**Итого:** отправьте на проверку ссылку на гитхаб-репозиторий с вашим проектом. 
