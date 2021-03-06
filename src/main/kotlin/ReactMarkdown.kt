import react.RBuilder
import react.RProps
import react.ReactElement
import react.child
import kotlin.js.json

@JsModule("react-markdown")
@JsNonModule
internal external fun ReactMarkdown(props: ReactMarkdownProps): ReactElement

@JsModule("remark-gfm")
@JsNonModule
external val gfm: dynamic

external interface ReactMarkdownProps : RProps {
    var children: String
    var plugins: Array<dynamic>
    var allowDangerousHtml: Boolean
    var renderers: dynamic
}

fun RBuilder.reactMarkdown(
    children: String,
    plugins: List<dynamic> = listOf(),
    allowDangerousHtml: Boolean = false
) {
    child(::ReactMarkdown) {
        attrs.children = children
        attrs.plugins = plugins.toTypedArray()
        attrs.allowDangerousHtml = allowDangerousHtml
        attrs.renderers = json("code" to prismRender)
    }
}
