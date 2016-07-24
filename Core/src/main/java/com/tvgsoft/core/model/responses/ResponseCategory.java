package com.tvgsoft.core.model.responses;

import com.google.gson.annotations.SerializedName;
import com.tvgsoft.core.model.entities.Category;
import java.util.List;

/**
 * Created by TVG on 7/24/16.
 */
public class ResponseCategory extends Response {

    //region Properties

    @SerializedName("categories")
    private List<Category> mCategories;

    //endregion

    //region Getter and Setter

    public List<Category> getCategories() {
        return mCategories;
    }

    //endregion

}
