package com.example.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yalex on 11.11.16.
 */
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
}
