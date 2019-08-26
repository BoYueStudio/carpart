package com.xiupeilian.carpart.service;

import com.xiupeilian.carpart.model.Dymsn;
import com.xiupeilian.carpart.model.Notice;

import java.util.List;

public interface DymsnService {

    List<Dymsn> findDymsn();

    List<Notice> findNotice();
}
