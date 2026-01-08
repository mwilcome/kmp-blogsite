type Nullable<T> = T | null | undefined
declare function KtSingleton<T>(): T & (abstract new() => any);
export declare namespace com.mikewilcome.kmp {
    abstract class SharedApi extends KtSingleton<SharedApi.$metadata$.constructor>() {
        private constructor();
    }
    namespace SharedApi {
        /** @deprecated $metadata$ is used for internal purposes, please don't use it in your code, because it can be removed at any moment */
        namespace $metadata$ {
            abstract class constructor {
                add(a: number, b: number): number;
                subtract(a: number, b: number): number;
                private constructor();
            }
        }
    }
}
export as namespace kmp_shared_logic;