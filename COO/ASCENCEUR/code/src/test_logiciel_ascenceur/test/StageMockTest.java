package test_logiciel_ascenceur.test;

import logiciel_ascenseur.mock.PhysicalMockFactory;
import logiciel_ascenseur.mock.cabin.CabinMock;
import logiciel_ascenseur.mock.cabin.CabinState;
import logiciel_ascenseur.mock.stage.StageMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StageMockTest {
    private StageMock s1, s2, s3;
    private CabinMock c1;
    @Before
    public void init(){
        PhysicalMockFactory p = new PhysicalMockFactory();
        int numcabin = 1;
        int nums1 = 1, nums2 = 2, nums3 = 3;
        //s1 is a 1
        p.creerBouton(nums1,nums1);
        p.creerPorte(nums1,nums1,nums1);
        p.creerEtage(nums1,nums1,nums1);

        //s2 is a 2
        p.creerBouton(nums2,nums2);
        p.creerPorte(nums2,nums2,nums2);
        p.creerEtage(nums2,nums2,nums2);

        //s3 is a 3
        p.creerBouton(nums3,nums3);
        p.creerPorte(nums3,nums3,nums3);
        p.creerEtage(nums3,nums3,nums3);

        c1 = p.getCabins().get(0);
        s1 = p.getStages().get(nums1-1);
        s2 = p.getStages().get(nums2-1);
        s3 = p.getStages().get(nums3-1);
    }

    @Test
    public void getEtage() throws Exception {
        assertEquals(1,s1.getEtage());
        assertEquals(2,s2.getEtage());
        assertEquals(3,s3.getEtage());
    }

    @Test
    public void pressButton() throws Exception {
    }

}