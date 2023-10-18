import java.util.List;

public class PaginationHelper<I> {

    private int itemsPerPage;
    private List<I> collection;

    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.collection.size() % this.itemsPerPage == 0 ? this.collection.size() / this.itemsPerPage : this.collection.size() / this.itemsPerPage+1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex+1 > this.pageCount() || pageIndex < 0){
            return -1;
        }
        if (this.collection.size() % this.itemsPerPage == 0) {
            return this.itemsPerPage;
        }

        if (pageIndex+1 < this.pageCount()) {
            return itemsPerPage;
        }

        int pagesCount = this.collection.size();

        while (pagesCount > this.itemsPerPage) {
            pagesCount = pagesCount - this.itemsPerPage;
        }
        return pagesCount;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if ((this.collection.size() > 0 && itemIndex < 0) || (this.collection.size() > 0 && itemIndex+1 > this.collection.size()) || this.collection.size() == 0){
            return -1;
        }
        return itemIndex < this.itemsPerPage ? 0 : itemIndex/this.itemsPerPage;
    }
}