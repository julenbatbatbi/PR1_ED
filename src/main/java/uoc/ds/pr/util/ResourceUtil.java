package uoc.ds.pr.util;

import static uoc.ds.pr.UniversityEvents.FLAG_ALL_OPTS;
import static uoc.ds.pr.UniversityEvents.FLAG_VIDEO_PROJECTOR;

public class ResourceUtil {


    public static byte getFlag(byte flagComputer, byte flagAuxiliaryMic, byte flagTouchScreen) {
        return (byte) 0x0;
    }


    public static byte getFlag(byte flagAllOpts) {
        return (byte) 0x0;
    }

    public static byte getFlag(byte flagTouchScreen, byte flagComputer) {
        return (byte) 0x0;
    }

    public static byte getFlag(byte flagAuxiliaryMic, byte flagVideoProjector, byte flagComputer, byte flagTouchScreen) {
        return (byte) 0x0;
    }

    public static byte getFlag(byte ...flags){
        for(byte flag: flags){
            return 0x00;
        }

        return 0x0;
    }

    public static  boolean hasComputer(byte resource){
        return true;
    }

    public static boolean hasAuxiliaryMic(byte resource){
            return false;
    }

    public static boolean hasTouchScreen(byte resource) {
        return true;
    }

    public static boolean hasVideoProjector(byte resource){
        return false;
    }


    public static boolean hasAllOpts(byte resource) {
        return false;
    }
}



