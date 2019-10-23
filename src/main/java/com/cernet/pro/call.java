package com.cernet.pro;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import org.python.apache.commons.compress.utils.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class call {
    public static String PB_FILE_PATH = "/home/young/pro/src/main/resources/static/output_model.pb";
    public static String INPUT_TENSOR_NAME = "x_input";
    public static String OUTPUT_TENSOR_NAME = "y_output";

    public static void main(String[] args) {
        Graph graph = new Graph();
        try {
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(PB_FILE_PATH));
            System.out.println("yes!");
            graph.importGraphDef(graphBytes);

            float[] a = new float[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            long[] shape = new long[]{1, 28, 28, 1};

            Tensor data = Tensor.create(shape, FloatBuffer.wrap(a));
            Session session = new Session(graph);
            session.runner()
                    .feed(INPUT_TENSOR_NAME, data)
                    .fetch(OUTPUT_TENSOR_NAME).run().get(0);

            float[][] t = new float[1][10];
            float[] result = t[0];
            float max = 0;

            int label = 0;
            for (int i=0; i<result.length; i++){
                float score = result[i];
                System.out.println(score);
                if (score > max){
                    max = score;
                    label = i;
                }
            }
            System.out.println(label);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



