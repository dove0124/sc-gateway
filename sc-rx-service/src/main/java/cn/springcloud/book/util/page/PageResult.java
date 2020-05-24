package cn.springcloud.book.util.page;

import java.util.Collection;

public class PageResult<T> {

   private final Page page;
   private final Collection<T> result;

   public PageResult(Page page, Collection<T> result) {
      this.page = page;
      this.result = result;
   }

   public Page getPage() {
      return page;
   }

   public Collection<T> getResult() {
      return result;
   }
}
