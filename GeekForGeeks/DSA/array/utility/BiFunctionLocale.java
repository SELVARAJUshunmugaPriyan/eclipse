package array.utility;

@FunctionalInterface
public interface BiFunctionLocale<T, U, V>
{
	V bifunc(T t, U u);
}