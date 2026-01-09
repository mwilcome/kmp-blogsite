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
                getDocument(id: string): Nullable<com.mikewilcome.kmp.content.ContentDocument>;
                private constructor();
            }
        }
    }
}
export declare namespace com.mikewilcome.kmp.content {
    class ContentDocument {
        constructor(schemaVersion: number, id: string, title: string, meta: Nullable<string>, blocks: Array<com.mikewilcome.kmp.content.ContentBlock>);
        get schemaVersion(): number;
        get id(): string;
        get title(): string;
        get meta(): Nullable<string>;
        get blocks(): Array<com.mikewilcome.kmp.content.ContentBlock>;
    }
    namespace ContentDocument {
        /** @deprecated $metadata$ is used for internal purposes, please don't use it in your code, because it can be removed at any moment */
        namespace $metadata$ {
            const constructor: abstract new () => ContentDocument;
        }
    }
    class ContentBlock {
        constructor(type: string, text: Nullable<string>, level: Nullable<number>, items: Nullable<Array<string>>);
        get type(): string;
        get text(): Nullable<string>;
        get level(): Nullable<number>;
        get items(): Nullable<Array<string>>;
    }
    namespace ContentBlock {
        /** @deprecated $metadata$ is used for internal purposes, please don't use it in your code, because it can be removed at any moment */
        namespace $metadata$ {
            const constructor: abstract new () => ContentBlock;
        }
        abstract class Companion extends KtSingleton<Companion.$metadata$.constructor>() {
            private constructor();
        }
        namespace Companion {
            /** @deprecated $metadata$ is used for internal purposes, please don't use it in your code, because it can be removed at any moment */
            namespace $metadata$ {
                abstract class constructor {
                    heading(text: string, level?: number): com.mikewilcome.kmp.content.ContentBlock;
                    paragraph(text: string): com.mikewilcome.kmp.content.ContentBlock;
                    numberedList(items: Array<string>): com.mikewilcome.kmp.content.ContentBlock;
                    private constructor();
                }
            }
        }
    }
}
export as namespace kmp_shared_logic;