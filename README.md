# Reproduction Steps for unexpected Figwheel-Main behavior with core node modules

## PROBLEM:

I am able to access core node modules in my build but not in my tests.

## REPRODUCTION:
1. Run `git clone git@github.com:eccentric-j/minirepro-fig-test-deps.git`
2. Run `cd minirepro-fig-test-deps`
3. Run `lein fig:build`
4. Run `node target/node/dev/dev-main.js`
5. You should see output similar to:
   ```
   Loaded main script
   Running main fn
   #js [".gitignore" "README.md" "dev.cljs.edn" "figwheel-main.edn" "node_modules" "package-lock.json" "package.json" "project.clj" "src" "target" "test" "test.cljs.edn"]
   ```
6. It worked. Now run `lein fig:test`

## EXPECTED:
  - Tests pass or fail

## ACTUAL:
  - Tests never run
  - Error is thrown:
    ```clojure
    No such namespace: fs, could not locate fs.cljs, fs.cljc, or JavaScript source providing "fs" in file minirepro-fig-test-deps/src/minirepro_fig_test_deps/core.cljs {:tag :cljs/analysis-error}
        at cljs.analyzer$error.invokeStatic(analyzer.cljc:706)
        at cljs.analyzer$error.invoke(analyzer.cljc:702)
        at cljs.analyzer$error.invokeStatic(analyzer.cljc:704)
        at cljs.analyzer$error.invoke(analyzer.cljc:702)
        at cljs.analyzer$analyze_deps.invokeStatic(analyzer.cljc:2159)
        at cljs.analyzer$analyze_deps.invoke(analyzer.cljc:2133)
        at cljs.analyzer$ns_side_effects.invokeStatic(analyzer.cljc:3509)
        at cljs.analyzer$ns_side_effects.invoke(analyzer.cljc:3504)
        at cljs.analyzer$analyze_STAR_$fn__2534.invoke(analyzer.cljc:3629)
        at clojure.lang.PersistentVector.reduce(PersistentVector.java:343)
        at clojure.core$reduce.invokeStatic(core.clj:6827)
        at clojure.core$reduce.invoke(core.clj:6810)
        at cljs.analyzer$analyze_STAR_.invokeStatic(analyzer.cljc:3629)
        at cljs.analyzer$analyze_STAR_.invoke(analyzer.cljc:3619)
        at cljs.analyzer$analyze.invokeStatic(analyzer.cljc:3649)
        at cljs.analyzer$analyze.invoke(analyzer.cljc:3631)
        at cljs.compiler$emit_source.invokeStatic(compiler.cljc:1390)
        at cljs.compiler$emit_source.invoke(compiler.cljc:1369)
        at cljs.compiler$compile_file_STAR_$fn__3696.invoke(compiler.cljc:1471)
        at cljs.compiler$with_core_cljs.invokeStatic(compiler.cljc:1289)
        at cljs.compiler$with_core_cljs.invoke(compiler.cljc:1278)
        at cljs.compiler$compile_file_STAR_.invokeStatic(compiler.cljc:1455)
        at cljs.compiler$compile_file_STAR_.invoke(compiler.cljc:1448)
        at cljs.compiler$compile_file$fn__3727.invoke(compiler.cljc:1553)
        ... 74 more
    ```

## Questions:
- Am I importing core node modules incorrectly?
- Why does it work with npm deps but not built-in node modules?
- If the answer is simple, should I make a PR to update the docs?
