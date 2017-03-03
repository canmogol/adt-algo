package com.fererlab.ps.intercode.w16.story;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.fererlab.ps.intercode.w16.FindSecondLargestBinaryTree.BinaryTreeNode;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindSecondLargestBinaryTreeTest {

    private BinaryTreeNode binaryTree;
    private Integer secondLargestFound;

    @Given("a binary tree with second largest element $root, $secondLargest, $largest")
    public void givenABinaryTree(int root, int secondLargest, int largest) {
        /*
                      root
                            secondLargest
                                        largest
         */
        binaryTree = new BinaryTreeNode(root);
        BinaryTreeNode right = binaryTree.insertRight(secondLargest);
        BinaryTreeNode right_right = right.insertRight(largest);
    }

    @When("I find the second largest element")
    public void iFindTheSecondElement() throws Exception {
        if (binaryTree == null) {
            throw new Exception("there are no elements in tree");
        }

        BinaryTreeNode currentNode = binaryTree;
        BinaryTreeNode parent = binaryTree;
        while (currentNode.right != null) {
            parent = currentNode;
            currentNode = currentNode.right;
        }

        if (parent.equals(currentNode)) {
            throw new Exception("there is only one element in the tree");
        } else {
            if (currentNode.left != null) {
                secondLargestFound = currentNode.left.value;
            } else {
                secondLargestFound = parent.value;
            }
        }
    }

    @Then("the second element should be $secondLargest")
    public void theSecondElementShouldBeFound(int secondLargest) {
        assertThat("second largest element could not be found",
                secondLargest, is(secondLargestFound));
    }


}
