# cljs-log

Logging macros for Clojurescript. Depending on configured log level,
logging calls will be elided from resulting compiled JS...

## Leiningen coordinates

```clj
[cljs-log "0.1.0"]
```

## Usage

```clj
(require '[cljs-log.core :refer [debug info warn severe]])

(enable-console-print!)

(debug "foo bar" {:a 23 :b 42})
;; 
```

Compile Clojurescript with log level env var (by default *all* levels are enabled):

* 1 => debug (all)
* 2 => info or higher
* 3 => warn or higher
* 4 => severe only

```
LOG_LEVEL=3 lein cljsbuild once production

# or..

LOG_LEVEL=2 rlwrap lein figwheel
```

Alternatively, if using the `lein-environ` plugin, log levels can be
configured for different lein profiles:

```clj
:profiles {:dev        {:env {:log-level 2}
           :production {:env {:log-level 4}}}
```

## License

Copyright © 2015 Karsten Schmidt

Distributed under the
[Apache Software License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
