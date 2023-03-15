<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* message/_form.html.twig */
class __TwigTemplate_d5ca83b776ae0770332b441e7e06ef86 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "message/_form.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "message/_form.html.twig"));

        // line 1
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 1, $this->source); })()), 'form_start');
        echo "
";
        // line 2
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 2, $this->source); })()), "text", [], "any", false, false, false, 2), 'row', ["label" => "Texte", "attr" => ["rows" => 6]]);
        echo "

<hr/>
<div class=\"row mb-2\">
\t<div class=\"col-lg-2\">
\t\t&nbsp;
\t</div>
\t<div class=\"col-lg-10\">
\t\tLa <kbd>longitude</kbd> et la <kbd>latitude</kbd>
\t\tsont deux angles exprimés en degrés. Ils représentent une position géographique sur une
\t\t<em>sphère</em>.
        La <kbd>longitude</kbd>
\t\test l'angle entre le
        <a href=\"https://fr.wikipedia.org/wiki/Premier_m%C3%A9ridien\">méridien de Greenwich</a>
\t\tet la position cible (entre -180 et 180), et la
\t\t<kbd>latitude</kbd>
\t\test l'angle entre l'équateur et la position cible (entre -90 et 90).
\t\t<br/>
\t\t<img src=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("lnglat.png"), "html", null, true);
        echo "\" width=\"480\"/>
\t</div>
</div>

";
        // line 24
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 24, $this->source); })()), "address", [], "any", false, false, false, 24), 'row', ["label" => "Address."]);
        echo "

<div class=\"row\">
<div class=\"col-sm-2\">&nbsp;</div>
<div class=\"col-sm-10\">
<button class=\"btn btn-primary\">";
        // line 29
        echo twig_escape_filter($this->env, ((array_key_exists("button_label", $context)) ? (_twig_default_filter((isset($context["button_label"]) || array_key_exists("button_label", $context) ? $context["button_label"] : (function () { throw new RuntimeError('Variable "button_label" does not exist.', 29, $this->source); })()), "Enregistrer")) : ("Enregistrer")), "html", null, true);
        echo "</button>
</div>
</div>

";
        // line 33
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 33, $this->source); })()), 'form_end');
        echo "
";
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

    }

    public function getTemplateName()
    {
        return "message/_form.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  90 => 33,  83 => 29,  75 => 24,  68 => 20,  47 => 2,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{{ form_start(form) }}
{{ form_row(form.text, {'label': 'Texte', 'attr': {'rows': 6}}) }}

<hr/>
<div class=\"row mb-2\">
\t<div class=\"col-lg-2\">
\t\t&nbsp;
\t</div>
\t<div class=\"col-lg-10\">
\t\tLa <kbd>longitude</kbd> et la <kbd>latitude</kbd>
\t\tsont deux angles exprimés en degrés. Ils représentent une position géographique sur une
\t\t<em>sphère</em>.
        La <kbd>longitude</kbd>
\t\test l'angle entre le
        <a href=\"https://fr.wikipedia.org/wiki/Premier_m%C3%A9ridien\">méridien de Greenwich</a>
\t\tet la position cible (entre -180 et 180), et la
\t\t<kbd>latitude</kbd>
\t\test l'angle entre l'équateur et la position cible (entre -90 et 90).
\t\t<br/>
\t\t<img src=\"{{ asset('lnglat.png') }}\" width=\"480\"/>
\t</div>
</div>

{{ form_row(form.address, {'label': 'Address.'}) }}

<div class=\"row\">
<div class=\"col-sm-2\">&nbsp;</div>
<div class=\"col-sm-10\">
<button class=\"btn btn-primary\">{{ button_label|default('Enregistrer') }}</button>
</div>
</div>

{{ form_end(form) }}
", "message/_form.html.twig", "/home/maximlyoen/Bureau/CoursIutInfo/geochat-architecture-logiciel/templates/message/_form.html.twig");
    }
}
