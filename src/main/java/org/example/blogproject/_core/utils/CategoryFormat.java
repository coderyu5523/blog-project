package org.example.blogproject._core.utils;

public class CategoryFormat {
    public static String translateCategory(String category) {
        switch (category) {
            case "스포츠":
                return "sports";
            case "영화":
                return "movies";
            case "게임":
                return "games";
            case "음식":
                return "foods";
            default:
                return "others";
        }
    }

}
