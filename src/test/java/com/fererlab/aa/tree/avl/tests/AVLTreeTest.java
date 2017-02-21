package com.fererlab.aa.tree.avl.tests;

import com.fererlab.aa.tree.avl.AVLTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * can
 */
public class AVLTreeTest {

    @Test
    public void testInsertRotateNormal() throws Exception {
        AVLTree<Integer> tree = new AVLTree<>();
        insertRotateNormal(tree);
    }

    private void insertRotateNormal(AVLTree<Integer> tree) {
        List<Integer> values;

        tree.insert(10);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Collections.singletonList(10));

        tree.insert(15);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(10, 15));

        tree.insert(20);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(15, 10, 20));


        tree.insert(25);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(15, 10, 20, 25));


        tree.insert(30);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(15, 10, 25, 20, 30));


        tree.insert(35);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(25, 15, 10, 20, 30, 35));


        tree.insert(40);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(25, 15, 10, 20, 35, 30, 40));

    }

    @Test
    public void testInsertNormalize() throws Exception {
        insertNormalize1(new AVLTree<>());
        insertNormalize2(new AVLTree<>());
    }

    private void insertNormalize2(AVLTree<Integer> tree) {
        List<Integer> values;

        tree.insert(10);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Collections.singletonList(10));

        tree.insert(5);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(10, 5));

        tree.insert(7);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(7, 5, 10));

    }

    private void insertNormalize1(AVLTree<Integer> tree) {
        List<Integer> values;

        tree.insert(10);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Collections.singletonList(10));

        tree.insert(20);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(10, 20));

        tree.insert(15);
        values = tree.traverse();
        System.out.println(values);
        assertEquals(values, Arrays.asList(15, 10, 20));

    }


}