package com.goods.search.service;

import com.goods.display.api.DTO.HistoryPriceResponseDTO;
import com.goods.display.api.DTO.SearchResponseDTO;
import com.goods.search.api.DTO.HistoryPriceRequestDTO;
import com.goods.search.api.DTO.SearchRequestDTO;
import com.goods.search.entity.Product;

import java.util.List;


public interface SearchService {

	public SearchResponseDTO search(SearchRequestDTO searchRequestDTO);

	public HistoryPriceResponseDTO historyPrice(HistoryPriceRequestDTO historyPriceRequestDTO);
}
