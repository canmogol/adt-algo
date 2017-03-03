package com.fererlab.ps.intercode.w16.story;

import com.fererlab.BaseJUnitStory;

import java.util.Collections;
import java.util.List;

public class FindSecondLargestElementInBinaryTree extends BaseJUnitStory {

    @Override
    public List<?> getSteps() {
        return Collections.singletonList(new FindSecondLargestBinaryTreeTest());
    }

}
