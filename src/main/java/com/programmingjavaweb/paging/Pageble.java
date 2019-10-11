package com.programmingjavaweb.paging;

import com.programmingjavaweb.sort.Sorter;

public interface Pageble {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();
}
