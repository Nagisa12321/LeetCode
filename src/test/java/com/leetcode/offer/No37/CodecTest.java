package com.leetcode.offer.No37;

import com.leetcode.struct.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodecTest {

    private Codec codec = new Codec();

    @Test
    public void serialize() {

        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        String serialize = codec.serialize(node);
        System.out.println(serialize);
    }

    @Test
    public void deserialize() {
        // TreeNode node = codec.deserialize("1 2 null null 3 4 null null 5 null null");
        // TreeNode node = codec.deserialize("1 null null");
        // TreeNode node = codec.deserialize("1 2 4 null null 5 null null 3 null null ");
        TreeNode node = codec.deserialize("3 2 1 null null 4 null null");
        // TreeNode node = codec.deserialize("1 2 null null null");
        System.out.println(node);
    }

}