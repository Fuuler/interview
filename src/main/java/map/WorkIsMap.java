package map;

import java.util.*;
import java.util.Map.Entry;

public class WorkIsMap {
    public static void main(String[] args) {
        /**
         * стандартное создание и заполнение мапы
         */

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "string 1");
        map.put(2, "string 2");
        map.put(3, "string 3");

        /**
         * получение значений по ключу
         */

        String string3 = map.get(3);
        String string2 = map.get(2);
        String string1 = map.get(1);

        /** 0. Как перебрать все значения Map
         перебор значений - самая частая операция, которая выполняется с мапой.
         Все пары (ключ-значение) хранятся во внутреннем интерфейсе Map.Entry, а чтобы
         получить их, нужно вызвать метод entrySet(). Он возвращает множество (Set) пар,
         которые можно перебрать в цикле
         */
        for (Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        /**
         * или использую итератор
         */
        Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Entry<Integer, String> entry = itr.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        /** 1. Как конвертировать Map в List
         * У интерфейса Map существует 3 метода, которые возращают перечень элементов
         * keySet() - возвращает множество(Set) ключей;
         * values() - возвращает коллекцию(Collection) значений;
         * entrySet() - возвращает множество(Set) наборов "ключ-значение".
         * Если заглянуть в конструкторы класса ArrayList, можно заметить, что существует
         * конструктор с аргументом типа Collection. Так как Set является наследником Collection,
         * результаты всех вышеупомянутых методов можно передать в конструктор класса
         * ArrayList. Таким образом, мы создадим новые списки и заполним их значениями из Map
         */
        List<Integer> keyList = new ArrayList<>(map.keySet());
        List<String> valueList = new ArrayList<>(map.values());
        List<Entry<Integer, String>> entryList = new ArrayList<>(map.entrySet());

        /** 2. Как отсортировать ключи мапы
         * Сортировка мап - тоже довольно частая операция в программировании.
         * Сделать это можно несколькими способами:
         * Поместить Map.Entry в список и отсортировать его, используя Comparator
         * в компараторе будем сравнивать исключительно ключи пар
         */

        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, String>>() {
            @Override
            public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2){
                return o1.getKey() - o2.getKey();
            }
        });

        /**
         * использовать sortedMap, а точнее, ее реализацию - TreeMap, которая в конструкторе принимает
         * Comparator. Данный компаратор будет применяться к ключам мапы, поэтому ключами должны быть классы,
         * реализующие интерфейс Comparable.
         * В отличие от первого способа, использую SortedMap, мы всегда будем хранить данные
         * в отсортированном виде.
         */
        SortedMap<Integer, String> sortedMap = new TreeMap<>(Comparator.comparingInt(o -> o));


        /** 3. Как отсортировать значения мапы.
         * Здесь стоит использовать подход, аналогичный первому для ключей-получать список
         * значений и сортировать их в списке.
         */
        List<Map.Entry<Integer, String>> valuesList = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        /** 4. В чем разница между HashMap, TreeMap, и HashTable
         * Существуют 3 основные реализации интерфейса Map. У каждой из них есть свои особенности
         * 1. Порядок элементов. HashMap и Hashtable не гарантируют, что элементы будут храниться в порядке добавления.
         * Кроме того, они не гарантируют, что порядок элементов не будет менять со временем. В свою очередь, TreeMap
         * гарантирует хранение элементов в порядке добавления или же в соответствии с заданным компаратором.
         * 2. Допустимы значения. HashMap позволяет иметь ключ и значение null, HasTable-нет. TreeMap может использовать
         * значения null, только если это позволяет компаратор. Без использования компаратора(при хранении пар в порядке добавления)
         * значение null не допускается
         * 3. Синхронизация. Только HashTable синхронизирована, остальные-нет. Если к мапе не будут обращаться разные потоки,
         * рекомендуется использовать HashMap вместо HashTable.
         */

        /** 5. Как создать двунаправленную мапу
         * Иногда появляется необходимость использовать структуру данных, в которой и ключи, и значения будут уникальными,
         * то есть мапа будет содержать пары "ключ-ключ".
         * Такая структура данных позволяет создать "инвертированный просмотр/поиск" по мапе. То есть, мы можем найти ключ
         * по его значению. Эту структуру данных называют двунаправленной мапой, которая, к сожалению, не поддерживается JDK.
         * Но, к счастью, ее реализацию можно найти в библиотеках Apache Common Collections или Guava. Там она называется
         * BidiMap и ИшЬфз соотвественно. Эти реализации вводят ограничения на уникальность ключей и значений. Таким образом получаются
         * отношения one-to-one.
         */

        /** 6. Как создать пустую Map
         * обычная инициализация объекта
         */
        Map<Integer, String> emptyMap = new HashMap<>();
        /**
         * создание неизменяемой (immutable) пустой мапы
         */
        Map<Integer, String> emptyMap2 = Collections.emptyMap();

    }
}
