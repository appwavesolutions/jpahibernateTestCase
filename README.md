# jpahibernateTestCase

## Options pour gérer les données legacy sans `params.type`

| Solution | Principe | Avantages | Inconvénients | Effort | Risques |
|---|---|---|---|---|---|
| Migrer les données (idéal) | Backfill `params.type` (ou copier `request.type` → `params.type`) | Propre, standard, maintenance simple | Besoin de droits DB, opération de migration | Faible–Moyen | Faibles si script idempotent |
| Type externe (implémenté) | `Params` lit `request.type` via EXTERNAL_PROPERTY | Compatible sans `params.type`, pas de changement DB | Doit avoir toujours `request.type` | Très faible | Lignes sans `request.type` non supportées |
| JSON brut | `Request.params` en `JsonNode`/`Map` | Tolérance maximale aux formes legacy | Perte du typage et validations | Faible | Dette technique, erreurs runtime |
| Désérialiseur personnalisé (recommandé si pas de migration) | `JsonDeserializer<Params>`: décoder `params.type` string→JSON, inférer le sous-type par clés | Conserve DTO typés, compatible legacy, trajectoire progressive | Règles à maintenir, cas ambigus | Moyen | Ambiguïtés si données hétérogènes |
| Adaptateur service/contrôleur | Entité en `JsonNode`, conversion vers DTOs au service | Complexité isolée, transition progressive | Logique éparpillée/dupliquée | Moyen | Similaires au désérialiseur |
| Stratégie hybride | EXTERNAL_PROPERTY + désérialiseur maintenant, normalisation plus tard | Combine tolérance et cible propre | Deux étapes à gérer | Moyen | Glissement si la normalisation tarde |

Recommandation: migrer si possible; sinon désérialiseur personnalisé + EXTERNAL_PROPERTY, puis normaliser ultérieurement.
