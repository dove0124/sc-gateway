package cn.springcloud.book.util.converter;

import static java.util.stream.Collectors.toList;

import java.util.List;

public interface SuperConverter<T, R> {

    default List<R> convertToList(final List<T> input) {
        return input.stream().map(this::convert).collect(toList());
    }

    R convert(final T input);
}
