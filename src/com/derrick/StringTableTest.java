package com.derrick;

import java.util.UUID;
/**
 * String.intern()会使YGC变长
 * JJVM里存在一个叫做StringTable的数据结构，这个数据结构是一个Hashtable，
 * 在我们调用String.intern的时候其实就是先去这个StringTable里查找是否存在一个同名的项，
 * 如果存在就直接返回对应的对象，否则就往这个table里插入一项，指向这个String对象，
 * 那么再下次通过intern再来访问同名的String对象的时候，就会返回上次插入的这一项指向的String对象
 * FULL GC会清理StringTable
 * */
public class StringTableTest {
    public static void main(String args[]) {
        for (int i = 0; i < 10000000; i++) {
            uuid();
        }
    }

    public static void uuid() {
        UUID.randomUUID().toString().intern();
    }
}
