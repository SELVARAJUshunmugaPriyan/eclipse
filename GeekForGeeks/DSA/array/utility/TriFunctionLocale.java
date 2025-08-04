package array.utility;

@FunctionalInterface
public interface TriFunctionLocale<T, U, V, W>
{
	W trifunc(T t, U u, V v);
}