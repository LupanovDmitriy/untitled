import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class partArrTest {
    private  Main main;
    private int[] arr;
    private int separator;
    private int[] retArr;

    public partArrTest(int[] arr, int separator, int[] retArr) {
        this.arr = arr;
        this.separator = separator;
        this.retArr = retArr;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 7, 3},4,new int[]{5, 6, 7, 7, 3}},
                {new int[]{1, 2, 3, 0, 5, 6, 4, 7, 3},4,new int[]{7, 3}},
                {new int[]{1, 2, 3, 4, 7, 3},4,new int[]{7, 3}},
                {new int[]{1, 2, 3, 0, 5, 6, 7, 7, 3},4, throw new RuntimeException} //как проверить на ошибку именно этот пример?

        });
    }
    @Before
    public void init(){
        main = new Main();
    }


    @Test
    public void testPartArr(){
        Assert.assertArrayEquals(retArr,main.partArr(arr,separator));
    }
}
