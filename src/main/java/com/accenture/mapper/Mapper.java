package com.accenture.mapper;

public interface Mapper<SOURCE, TARGET> {

    TARGET mapTo(SOURCE source);

}
