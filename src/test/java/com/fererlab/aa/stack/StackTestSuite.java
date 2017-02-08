package com.fererlab.aa.stack;

import com.fererlab.aa.stack.tests.StackArrayListTest;
import com.fererlab.aa.stack.tests.StackFlowTest;
import com.fererlab.aa.stack.tests.StackLinkedListTest;
import com.fererlab.aa.stack.tests.StackTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * can
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	StackArrayListTest.class,
	StackLinkedListTest.class,
	StackTest.class,
	StackFlowTest.class
})
public class StackTestSuite {
}
