package uoc.ds.pr.util;

import uoc.ds.pr.UniversityEvents;

import static uoc.ds.pr.UniversityEvents.*;

public class ResourceUtil {


    public static byte getFlag(byte ...resources){
        byte flag = 0x0;
        for(byte resource: resources){
            flag = (byte) (flag | resource);
        }

        return flag;
    }

    public static  boolean hasComputer(byte resource){
        boolean res = (byte) (resource & FLAG_COMPUTER) == FLAG_COMPUTER;

        return res;
    }

    public static boolean hasAuxiliaryMic(byte resource){
            boolean res = (byte) (resource & FLAG_AUXILIARY_MIC) ==  FLAG_AUXILIARY_MIC;

            return res;
    }

    public static boolean hasTouchScreen(byte resource) {
        boolean res = (byte) (resource & FLAG_TOUCH_SCREEN) ==  FLAG_TOUCH_SCREEN;

        return res;
    }

    public static boolean hasVideoProjector(byte resource){
        boolean res = (byte) (resource & FLAG_VIDEO_PROJECTOR) == FLAG_VIDEO_PROJECTOR ;

        return res;
    }


    public static boolean hasAllOpts(byte resource) {
        boolean res = (byte) (resource & FLAG_ALL_OPTS) == FLAG_ALL_OPTS;

        return res;
    }
}



