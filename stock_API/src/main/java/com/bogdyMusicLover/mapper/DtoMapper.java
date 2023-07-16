package com.bogdyMusicLover.mapper;

import java.util.List;

public interface DtoMapper<T, R, K> {

    R mapEntityFromRequest(T request);

    K mapResponseFromEntity(R entity);

    List<K> mapListResponsesFromEntity(List<R> entities);

}
