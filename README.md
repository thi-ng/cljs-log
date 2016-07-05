# cljs-log

Logging macros for Clojurescript. Depending on configured log level,
logging calls will be *fully* elided from resulting compiled JS...

## Leiningen coordinates

```clj
[cljs-log "0.2.3"]
```

## Usage

```clj
(ns example
  (:require-macros
   [cljs-log.core :refer [debug info warn severe]]))

(debug "hello world" {:a 23 :b 42})
;; Fri Mar 20 2015 02:41:00 GMT+0000 (GMT) "DEBUG hello world {:a 23 :b 42}"
```

Compile Clojurescript with log level env var (by default *all* levels are enabled):

* 1 => debug (all)
* 2 => info or higher
* 3 => warn or higher
* 4 => severe only
* 5 => nothing

```
LOG_LEVEL=3 lein cljsbuild once production

# or..

LOG_LEVEL=2 rlwrap lein figwheel
```

Alternatively, if using the `lein-environ` plugin, log levels can be
configured for different lein profiles:

```clj
:plugins  [[lein-environ "1.0.0"]]
:profiles {:dev        {:env {:log-level 2}   ;; info+
           :production {:env {:log-level 4}}} ;; severe only
```

## License

Copyright © 2015 Karsten Schmidt

Distributed under the
[Apache Software License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
