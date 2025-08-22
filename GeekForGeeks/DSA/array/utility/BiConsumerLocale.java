package array.utility;

@FunctionalInterface
public interface BiConsumerLocale<T, U> {

	void accept(T t, U u);
	
}
